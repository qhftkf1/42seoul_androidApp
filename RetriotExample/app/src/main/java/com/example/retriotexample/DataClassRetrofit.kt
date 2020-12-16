package com.example.retriotexample

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "header", strict = false)
data class Header(@field:Element(name = "resultCode") var resultCode: String,
                  @field:Element(name = "resultMsg") var resultMsg: String)




@Root(name = "item", strict = false)
data class Item(@field:Element(name = "accDefRate") var accDefRate: String,
                @field:Element(name = "accExamCnt") var accExamCnt: String,
                @field:Element(name = "accExamCompCnt") var accExamCompCnt: String,
                @field:Element(name = "careCnt") var careCnt: String,
                @field:Element(name = "clearCnt") var clearCnt: String,
                @field:Element(name = "createDt") var createDt: String,
                @field:Element(name = "deathCnt") var deathCnt: String,
                @field:Element(name = "decideCnt") var decideCnt: String,
                @field:Element(name = "examCnt") var examCnt: String,
                @field:Element(name = "resultNegCnt")var resultNegCnt: String,
                @field:Element(name = "seq") var seq: String,
                @field:Element(name = "stateDt") var stateDt: String,
                @field:Element(name = "stateTime") var stateTime: String,
                @field:Element(name = "updateDate") var updateDate: String)

@Root(name = "items", strict = false)
data class Items(@field:ElementList(name = "item") var item: List<Item>)

@Root(name = "body", strict = false)
data class Body(@field:Element(name = "items") var items: Items,
                @field:Element(name = "numOfRows") var numOfRows: String,
                @field:Element(name = "pageNo") var pageNo: String,
                @field:Element(name = "totalCount") var totalCount: String)

@Root(name = "response", strict = false)
data class Response(@field:Element(name = "header") var header: Header,
                    @field:Element(name = "body") var body: Body)