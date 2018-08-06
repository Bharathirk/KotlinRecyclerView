package com.example.orgware.kotlinsample

class PersonDetail(_nameP: String,Nplace : String,profileimage :Int){

       var place: String=Nplace
           get() = field
    set(value) {
        field=value
    }

    var name :String = _nameP
        get() = field
    set(value) {
        field=value
    }
    var image :Int =profileimage
    get() = field
    set(value) {
        field=value
    }

}