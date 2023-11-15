package id.rivaldy.core.domain.usecase

/** Created by github.com/im-o on 11/15/2023. */

abstract class BaseUseCase<in Params, out T> {
    abstract suspend fun execute(params: Params): T
}