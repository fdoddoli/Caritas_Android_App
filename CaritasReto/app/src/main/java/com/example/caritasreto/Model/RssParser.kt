package com.example.caritasreto.Model

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream
class RssParser {
    private val rssItems = ArrayList<Noticias>()
    private var rssItem : Noticias ?= null
    private var text: String = ""
    private val expression = "<(\\\"[^\\\"]*\\\"|'[^']*'|[^'\\\">])*>".toRegex()
    private var textFinal: String = ""
    fun parse(inputStream: InputStream):List<Noticias> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            var foundItem = false
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagname = parser.name
                when (eventType) {
                    XmlPullParser.START_TAG -> if (tagname.equals("item", ignoreCase = true)) {
                        // create a new instance of noticia
                        foundItem = true
                        rssItem = Noticias()
                    }
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> if (tagname.equals("item", ignoreCase = true)) {
                        // add noticia object to list
                        rssItem?.let { rssItems.add(it) }
                        foundItem = false
                    } else if ( foundItem && tagname.equals("title", ignoreCase = true)) {
                        textFinal = expression.replace(text, "")
                        rssItem!!.title = textFinal
                    } else if (foundItem && tagname.equals("link", ignoreCase = true)) {
                        textFinal = expression.replace(text, "")
                        rssItem!!.link = textFinal
                    } else if (foundItem && tagname.equals("pubDate", ignoreCase = true)) {
                        textFinal = expression.replace(text, "")
                        rssItem!!.pubDate = textFinal
                    } else if (foundItem && tagname.equals("category", ignoreCase = true)) {
                        textFinal = expression.replace(text, "")
                        rssItem!!.category = textFinal
                    } else if (foundItem && tagname.equals("description", ignoreCase = true)) {
                        textFinal = expression.replace(text, "")
                        rssItem!!.description = textFinal
                    }
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return rssItems
    }
}