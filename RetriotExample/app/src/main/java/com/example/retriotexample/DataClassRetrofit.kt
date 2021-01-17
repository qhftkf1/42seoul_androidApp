package com.example.retriotexample

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "header", strict = false)
data class Header @JvmOverloads constructor(
    @field:Element(name = "resultCode") @param:Element(name = "resultCode") var resultCode: String,
    @field:Element(name = "resultMsg") @param:Element(name = "resultMsg") var resultMsg: String)


@Root(name = "item", strict = false)
data class Item @JvmOverloads constructor(
    @field:Element(name = "accDefRate", required = false)
    @param:Element(name = "accDefRate")
    var accDefRate: String? = null,

    @field:Element(name = "accExamCnt", required = false)
    @param:Element(name = "accExamCnt")
    var accExamCnt: String? = null,

    @field:Element(name = "accExamCompCnt", required = false)
    @param:Element(name = "accExamCompCnt")
    var accExamCompCnt: String? = null,

    @field:Element(name = "careCnt", required = false)
    @param:Element(name = "careCnt")
    var careCnt: String? = null,

    @field:Element(name = "clearCnt", required = false)
    @param:Element(name = "clearCnt")
    var clearCnt: String? = null,

    @field:Element(name = "createDt", required = false)
    @param:Element(name = "createDt")
    var createDt: String? = null,

    @field:Element(name = "deathCnt", required = false)
    @param:Element(name = "deathCnt")
    var deathCnt: String? = null,

    @field:Element(name = "decideCnt", required = false)
    @param:Element(name = "decideCnt")
    var decideCnt: String? = null,

    @field:Element(name = "examCnt", required = false)
    @param:Element(name = "examCnt")
    var examCnt: String? = null,

    @field:Element(name = "resutlNegCnt", required = false)
    @param:Element(name = "resutlNegCnt")
    var resutlNegCnt: String? = null,

    @field:Element(name = "seq", required = false)
    @param:Element(name = "seq")
    var seq: String? = null,

    @field:Element(name = "stateDt", required = false)
    @param:Element(name = "stateDt")
    var stateDt: String? = null,

//    @field:Element(name = "stateTime", required = false)
//    @param:Element(name = "stateTime")
//    var stateTime: String? = null,

    @field:Element(name = "updateDt", required = false)
    @param:Element(name = "updateDt")
    var updateDt: String? = null)


@Root(name = "items", strict = false)
data class Items @JvmOverloads constructor(
    @field:ElementList(inline = true, entry = "item", required = false)
    @param:ElementList(name = "item")
    var item: List<Item>)

@Root(name = "body", strict = false)
data class Body @JvmOverloads constructor(
    @field:Element(name = "items", required = false)  var items: Items? = null,
    @field:Element(name = "numOfRows", required = false) var numOfRows: String? = null,
    @field:Element(name = "pageNo", required = false) var pageNo: String? = null,
    @field:Element(name = "totalCount", required = false) var totalCount: String? = null)

@Root(name = "response", strict = false)
data class Response @JvmOverloads constructor(
    @field:Element(name = "header", required = false) @param:Element(name = "header") var header: Header?,
    @field:Element(name = "body", required = false) @param:Element(name = "body") var body: Body?)