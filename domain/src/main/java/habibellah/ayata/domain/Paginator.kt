package habibellah.ayata.domain

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}