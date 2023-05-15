package com.example.etpproject_newsapp

class news {

    private var status: String? = null
    private var totalResults: String? = null
    private var articles: ArrayList<modelclass?>? = null


    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getTotalResults(): String? {
        return totalResults
    }

    fun setTotalResults(totalResults: String?) {
        this.totalResults = totalResults
    }

    fun getArticles(): ArrayList<modelclass?>? {
        return articles
    }

    fun setArticles(articles: ArrayList<modelclass?>?) {
        this.articles = articles
    }

    fun news(status: String?, totalResults: String?, articles: ArrayList<modelclass?>?) {
        this.status = status
        this.totalResults = totalResults
        this.articles = articles
    }
    fun news()
    {

    }

}