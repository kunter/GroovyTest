package org.groovy.hakb


import groovy.xml.MarkupBuilder
import groovy.xml.XmlUtil
import groovy.xml.XmlUtil.*


/**
 * Created by root on 12.02.15.
 */
class XMLExample {
    static def CAR_RECORDS = '''
    <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
      <car name='P50' make='Peel' year='1962'>
        <country>Isle of Man</country>
        <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
      </car>
      <car name='Royale' make='Bugatti' year='2005'>
        <country>France</country>
        <record type='price'>Most Valuable Car at $15 million</record>
      </car>
    </records>
  '''
    def writer = new StringWriter()
    def xml = new MarkupBuilder(writer)
    def cars

    void write() {

        xml.records() {
            car(name: "HSV Maloo", make: "Holden", year: 2006) {
                country("Australia")
                record(type: "speed", "Production Pickup Truck with speed of 271kph") {
                }
            }
        }
        println(xml.mkp.toString())
    }

    void read() {


        def records = new XmlParser().parseText(XMLExample.CAR_RECORDS)
        def carRecordCount

        carRecordCount = records.car.size()

        println(carRecordCount)

        println("Record count ${records.depthFirst().size()}")

        cars = records.cars

        records.car.findAll {it.'@year'.contains('2005')}.each(){ ce ->

            println("ce is ${ce}")
            println("car name ${ce['@name']}")
            println("car make ${ce.make}")


        }
//        records.car.each() { ce ->
//
//            println("ce is ${ce}")
//            println("car name ${ce['@name']}")
//            println("car make ${ce.make}")
//
//
//        }


    }

    void readValues(id) {
        def serviceProtocols=[]
        def records = new XmlParser().parse("http://192.168.108.31:8888/getService?id=${id}")


        println("response text ${records.toString()}")
        println("serviceProtocolList size ${records.serviceProtocolList.serviceProtocol.size()}" )
        records.serviceProtocolList.serviceProtocol.each(){ serviceProtocol->
            serviceProtocols.add(serviceProtocol)
        }

        println(serviceProtocols)

    }


    static void main(args) {
        def xmlE = new XMLExample();
        xmlE.write()
        println(xmlE.writer.toString())
        xmlE.read()
//        xmlE.readValues(1)
    }
}
