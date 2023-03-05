package habibellah.ayata.domain.pagination

interface Pagination<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}