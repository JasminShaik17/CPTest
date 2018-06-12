package cubex.mahesh.cptest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {

    var lview:ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lview = findViewById(R.id.lview)

    /*    var resolver = contentResolver
        var c = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null,null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        var from = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER)
        var to = intArrayOf(R.id.tv1,R.id.tv2)
        var adapter = SimpleCursorAdapter(this,
                R.layout.indiview,c,from,to,0)
        lview?.adapter = adapter   */

        var resolver = contentResolver
        var c = resolver.query(
                CallLog.Calls.CONTENT_URI,
                null, null,null,
                null)

        var from = arrayOf(
                CallLog.Calls.CACHED_NAME,
                CallLog.Calls.NUMBER)
        var to = intArrayOf(R.id.tv1,R.id.tv2)
        var adapter = SimpleCursorAdapter(this,
                R.layout.indiview,c,from,to,0)
        lview?.adapter = adapter
    }
}

