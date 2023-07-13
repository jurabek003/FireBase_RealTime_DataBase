package uz.turgunboyevjurabek.firebaserealtimedatabase.madels

import java.text.SimpleDateFormat
import java.util.Date

class MyMessage {
    var id:String?=null
    var title:String?=null

    constructor(id: String?, title: String?) {
        this.id = id
        this.title = title
    }

    constructor()

    var time=SimpleDateFormat("dd:MM:yyyy_hh:ss").format(Date())


}