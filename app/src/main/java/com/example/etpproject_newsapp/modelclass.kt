package com.example.etpproject_newsapp

class modelclass {

    private var author: String? = null
    private  var title:kotlin.String? = null
    private  var description:kotlin.String? = null
    private  var url:kotlin.String? = null
    private  var urlToImage:kotlin.String? = null
    private  var publishedAt:kotlin.String? = null

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getUrlToImage(): String? {
        return urlToImage
    }

    fun setUrlToImage(urlToImage: String) {
        this.urlToImage = urlToImage
    }

    fun getPublishedAt(): String? {
        return publishedAt
    }

    fun setPublishedAt(publishedAt: String) {
        this.publishedAt = publishedAt
    }

    fun ModelClass() {}

    fun ModelClass(
        author: String?,
        title: String,
        description: String,
        url: String,
        urlToImage: String,
        published: String
    ) {
        this.author = author
        this.title = title
        this.description = description
        this.url = url
        this.urlToImage = urlToImage
        this.publishedAt = published
    }


}