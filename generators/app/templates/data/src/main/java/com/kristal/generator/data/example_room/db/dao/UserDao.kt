package <%= appPackage %>.data.example_room.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.Query
import <%= appPackage %>.data.example_room.db.entity.UserEntity

/**
 * Created by Dwi_Ari on 11/16/17.
 */

@Dao
interface UserDao {
    @Query("select * from user")
    fun loadAllUsers(): List<UserEntity>

    @Query("select * from user where id = :id")
    fun loadUserById(id: Int): UserEntity

    @Query("select * from user where name = :firstName and lastName = :lastName")
    fun findByNameAndLastName(firstName: String, lastName: String): List<UserEntity>

    @Insert(onConflict = IGNORE)
    fun insertUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("delete from user where name like :badName OR lastName like :badName")
    fun deleteUsersByName(badName: String): Int

    @Insert(onConflict = IGNORE)
    fun insertOrReplaceUsers(vararg users: UserEntity)

    @Delete
    fun deleteUsers(user1: UserEntity, user2: UserEntity)

    @Query("SELECT * FROM User WHERE :age == :age")
    fun findYoungerThan(age: Int):
            // TODO: Fix this!
            List<UserEntity>

    @Query("SELECT * FROM User WHERE age < :age")
    fun findYoungerThanSolution(age: Int): List<UserEntity>

    @Query("DELETE FROM User")
    fun deleteAll()
}
