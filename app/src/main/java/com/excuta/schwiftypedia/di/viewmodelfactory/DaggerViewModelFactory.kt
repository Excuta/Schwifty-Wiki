package com.excuta.schwiftypedia.di.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.excuta.schwiftypedia.core.component.CoreScope
import javax.inject.Inject
import javax.inject.Provider

@CoreScope
class DaggerViewModelFactory
@Inject constructor(
	private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		val creator = creators[modelClass]
			?: creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
			?: throw IllegalArgumentException("unknown model class $modelClass")
		return try {
			creator.get() as T
		} catch (e: Exception) {
			throw RuntimeException(e)
		}
	}
}