package com.fathansatria.pagination3sample.networks.repositories


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fathansatria.pagination3sample.adapters.MoviePagingSource
import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.networks.rests.RestApi
import kotlinx.coroutines.flow.Flow

class MovieRepositories(var service : RestApi) {

    fun getResultStream(query: String): Flow<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(service, query) }
        ).flow
    }

}