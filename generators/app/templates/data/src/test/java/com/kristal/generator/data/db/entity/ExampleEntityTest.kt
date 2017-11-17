package <%= appPackage %>.data.db.entity

import android.content.ContentValues
import android.database.Cursor
import <%= appPackage %>.data.db.mapper.toExampleEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Dwi_Ari on 10/31/17.
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleEntityTest {

    @Mock
    lateinit var cv: ContentValues
    @Mock
    lateinit var cursor: Cursor

    val entity = ExampleEntity(
            "kata",
            "makna",
            "dateCreate",
            "dateUpdate"
    )

    @Test
    fun contentValue() {
        `when`(cv.get(ExampleEntity.KATA))
                .thenReturn(entity.kata)
        `when`(cv.get(ExampleEntity.MAKNA))
                .thenReturn(entity.makna)
        `when`(cv.get(ExampleEntity.DATE_UPDATE))
                .thenReturn(entity.dateUpdate)
        `when`(cv.get(ExampleEntity.DATE_CREATE))
                .thenReturn(entity.dateCreate)

        assertThat(cv.get(ExampleEntity.KATA))
                .isEqualTo(entity.kata)
        assertThat(cv.get(ExampleEntity.MAKNA))
                .isEqualTo(entity.makna)
        assertThat(cv.get(ExampleEntity.DATE_CREATE))
                .isEqualTo(entity.dateCreate)
        assertThat(cv.get(ExampleEntity.DATE_UPDATE))
                .isEqualTo(entity.dateUpdate)
    }

    @Test
    fun transform() {
        `when`(cursor.getColumnIndex(ExampleEntity.KATA))
                .thenReturn(0)
        `when`(cursor.getColumnIndex(ExampleEntity.MAKNA))
                .thenReturn(1)
        `when`(cursor.getColumnIndex(ExampleEntity.DATE_CREATE))
                .thenReturn(2)
        `when`(cursor.getColumnIndex(ExampleEntity.DATE_UPDATE))
                .thenReturn(3)
        `when`(cursor.getString(0)).
                thenReturn(entity.kata)
        `when`(cursor.getString(1)).
                thenReturn(entity.makna)
        `when`(cursor.getString(2)).
                thenReturn(entity.dateCreate)
        `when`(cursor.getString(3)).
                thenReturn(entity.dateUpdate)

        val data = cursor.toExampleEntity()

        assertThat(data.kata).isEqualTo(entity.kata)
        assertThat(data.makna).isEqualTo(entity.makna)
        assertThat(data.dateCreate).isEqualTo(entity.dateCreate)
        assertThat(data.dateUpdate).isEqualTo(entity.dateUpdate)
    }

}