package com.example.k_populare_libraries.room.dao

import androidx.room.*
import com.example.k_populare_libraries.room.RoomGithubRepository


@Dao
interface  RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubRepository>)

    @Update
    fun update(user: RoomGithubRepository)

    @Update
    fun update(vararg users: RoomGithubRepository)

    @Update
    fun update(users: List<RoomGithubRepository>)

    @Delete
    fun delete(user: RoomGithubRepository)

    @Delete
    fun delete(vararg users: RoomGithubRepository)

    @Delete
    fun delete(users: List<RoomGithubRepository>)

    @Query("SELECT * FROM RoomGithubRepository")
    fun getAll() : List<RoomGithubRepository>

    @Query("SELECT * FROM RoomGithubRepository WHERE userId = :userId")
    fun finForUser(userId: String): List<RoomGithubRepository>
}