package org.groovy.hakb

/**
 * Created by root on 11.02.15.
 */
class Test {
        def id
        def name
        def  dod

    static void main (args){
        def test=new Test(id:1,name:"lala",dod:new Date())
        println("Hello ${test.name} with id: ${test.id} , creattion date: ${test.dod}")

    }

}
