/*
 Navicat Premium Data Transfer

 Source Server         : MongoDB
 Source Server Type    : MongoDB
 Source Server Version : 60006
 Source Host           : localhost:27017
 Source Schema         : togaform

 Target Server Type    : MongoDB
 Target Server Version : 60006
 File Encoding         : 65001

 Date: 29/06/2023 00:33:12
*/


// ----------------------------
// Collection structure for answer
// ----------------------------
db.getCollection("answer").drop();
db.createCollection("answer");

// ----------------------------
// Documents of answer
// ----------------------------
db.getCollection("answer").insert([ {
    _id: ObjectId("649c200106bd4063f615437f"),
    userId: "334cd49558da50a6ed5cf2ca9757b4d5",
    answerTime: ISODate("2023-06-28T11:56:49.104Z"),
    quesnaire: "6496cda43a22bd2b70a1816b",
    answers: [
        [
            "A"
        ],
        [
            "测试"
        ],
        [
            "114514"
        ],
        [
            "1班"
        ],
        [
            "C"
        ],
        [
            "A",
            "B"
        ]
    ]
} ]);
db.getCollection("answer").insert([ {
    _id: ObjectId("649c201706bd4063f6154381"),
    userId: "45ff4b5c9f22483694d2d5729ff5fa95",
    answerTime: ISODate("2023-06-28T11:57:11.6Z"),
    quesnaire: "6496cda43a22bd2b70a1816b",
    answers: [
        [
            "B"
        ],
        [
            "测试2"
        ],
        [
            "1919810"
        ],
        [
            "2班"
        ],
        [
            "C"
        ],
        [
            "A"
        ]
    ]
} ]);

// ----------------------------
// Collection structure for question
// ----------------------------
db.getCollection("question").drop();
db.createCollection("question");

// ----------------------------
// Documents of question
// ----------------------------
db.getCollection("question").insert([ {
    _id: ObjectId("64987f7c0efcec430e3405b2"),
    title: "请填写你的姓名",
    description: "姓名可以填中文名，English is also OK. ",
    required: false,
    answerType: NumberInt("3")
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("64987f7c0efcec430e3405b3"),
    title: "请填写你的学号",
    description: "8位数字",
    required: false,
    answerType: NumberInt("3")
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("64987f7c0efcec430e3405b4"),
    title: "请填写你的班级",
    required: false,
    answerType: NumberInt("3")
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c43877347bb764f1cbd3d"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c43f0a175fd52693a4006"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c44788e0dc96d08b85224"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c44e7dc1f60372f27a77a"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c45b88b39870ab7cc365b"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c46bbf8e4b554bf484a22"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c46ef7d1c0e6fd6f28949"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c476f6488fe140e7dc045"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c476f6488fe140e7dc046"),
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c4c5494e4415fd0bad949"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);
db.getCollection("question").insert([ {
    _id: ObjectId("649c58300caf1e182becbab4"),
    title: "test1",
    required: false,
    answerType: NumberInt("0"),
    _class: "tgkt.togaform.entity.Question"
} ]);

// ----------------------------
// Collection structure for questionnaire
// ----------------------------
db.getCollection("questionnaire").drop();
db.createCollection("questionnaire");

// ----------------------------
// Documents of questionnaire
// ----------------------------
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649637270a6e0000f8002e32"),
    project: "13f614a14972aaad81ad230443eff4b2",
    title: "大学生恋爱观(行为)调查",
    createTime: ISODate("2022-06-24T00:21:59.677Z"),
    startTime: ISODate("2023-06-23T00:21:59.677Z"),
    endTime: ISODate("2023-06-25T00:21:59.677Z"),
    surveyType: "类型1",
    description: "aaa",
    available: true,
    questions: [
        {
            answerType: 3,
            description: "姓名可以填中文名，English is also OK. ",
            required: false,
            title: "请填写你的姓名"
        },
        {
            title: "请填写你的学号",
            description: "8位数字",
            required: false,
            answerType: NumberInt("3")
        },
        {
            title: "请填写你的班级",
            required: false,
            answerType: NumberInt("3")
        },
        {
            title: "选择题测试",
            required: "true",
            answerType: NumberInt("1"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                },
                {
                    key: "C",
                    value: "还是钝角"
                }
            ]
        },
        {
            title: "多选题",
            answerType: NumberInt("2"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                }
            ]
        }
    ],
    roles: [
        "2"
    ]
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("6496b301458a5f0a4668ee81"),
    title: "大学生学习动机状况调查（编辑过的）",
    available: true,
    createTime: ISODate("2023-06-24T00:21:59.677Z"),
    startTime: ISODate("2023-06-24T00:21:59.677Z"),
    endTime: ISODate("2023-07-24T00:21:59.677Z"),
    surveyType: "类型2",
    description: "aaa",
    project: "13f614a14972aaad81ad230443eff4b2",
    questions: [
        {
            _id: "",
            title: "编辑过的",
            required: false,
            description: "",
            answerType: NumberInt("3"),
            selections: [ ]
        }
    ],
    roles: [
        "1",
        "2"
    ],
    _class: "tgkt.togaform.entity.Quesnaire"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("6496cda43a22bd2b70a1816b"),
    title: "班级团建活动娱乐项目编辑过的",
    available: true,
    createTime: ISODate("2022-06-24T00:21:59.677Z"),
    startTime: ISODate("2023-06-28T11:14:19.675Z"),
    endTime: ISODate("2023-06-30T19:14:00.000Z"),
    surveyType: "类型3",
    description: "aaa",
    project: "3c2d8bac5d51e8d49330051b49a31c7a",
    questions: [
        {
            _id: "",
            title: "去哪里团建",
            required: false,
            description: "",
            answerType: NumberInt("1"),
            selections: [
                {
                    key: "A",
                    value: "沈阳"
                },
                {
                    key: "B",
                    value: "大连"
                },
                {
                    key: "C",
                    value: "本溪"
                },
                {
                    key: "D",
                    value: "鞍山"
                }
            ]
        },
        {
            title: "请填写你的姓名",
            required: false,
            description: "姓名可以填中文名，English is also OK. ",
            answerType: NumberInt("3")
        },
        {
            title: "请填写你的学号",
            required: false,
            description: "8位数字",
            answerType: NumberInt("3")
        },
        {
            title: "请填写你的班级",
            required: false,
            answerType: NumberInt("3")
        },
        {
            title: "选择题测试",
            required: true,
            answerType: NumberInt("1"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                },
                {
                    key: "C",
                    value: "还是钝角"
                }
            ]
        },
        {
            title: "多选题",
            required: false,
            answerType: NumberInt("2"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                }
            ]
        }
    ],
    roles: [
        "1",
        "2"
    ],
    _class: "tgkt.togaform.entity.Quesnaire"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c43867347bb764f1cbd3c"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c43efa175fd52693a4005"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c44788e0dc96d08b85223"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c44e7dc1f60372f27a779"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c45b88b39870ab7cc365a"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c46bbf8e4b554bf484a21"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c46ef7d1c0e6fd6f28948"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c476f6488fe140e7dc044"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c4c5494e4415fd0bad948"),
    start: NumberInt("0"),
    limit: NumberInt("0"),
    available: false,
    _class: "tgkt.togaform.request.QuesnaireListRequest",
    project: "13f614a14972aaad81ad230443eff4b2"
} ]);
db.getCollection("questionnaire").insert([ {
    _id: ObjectId("649c58300caf1e182becbab1"),
    title: "test1",
    available: false,
    createTime: ISODate("2023-06-28T15:56:32.438Z"),
    surveyType: "类型1",
    project: "13f614a14972aaad81ad230443eff4b2",
    _class: "tgkt.togaform.entity.Quesnaire"
} ]);

// ----------------------------
// Collection structure for template
// ----------------------------
db.getCollection("template").drop();
db.createCollection("template");

// ----------------------------
// Documents of template
// ----------------------------
db.getCollection("template").insert([ {
    _id: ObjectId("649804063e6d3257a1b28385"),
    title: "东大标准收集表",
    description: "东北大学学生基本信息收集，包含姓名班级学号",
    questions: [
        {
            answerType: 3,
            description: "姓名可以填中文名，English is also OK. ",
            required: false,
            title: "请填写你的姓名"
        },
        {
            title: "请填写你的学号",
            description: "8位数字",
            required: false,
            answerType: NumberInt("3")
        },
        {
            title: "请填写你的班级",
            required: false,
            answerType: NumberInt("3")
        },
        {
            title: "选择题测试",
            required: "true",
            answerType: NumberInt("1"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                },
                {
                    key: "C",
                    value: "还是钝角"
                }
            ]
        },
        {
            title: "多选题",
            answerType: NumberInt("2"),
            selections: [
                {
                    key: "A",
                    value: "钝角"
                },
                {
                    key: "B",
                    value: "钝角"
                }
            ]
        }
    ],
    createTime: ISODate("2023-06-25T09:08:22.289Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649807473e6d3257a1b28388"),
    createTime: ISODate("2023-06-25T17:21:21.000Z"),
    description: "关于在校大学生XX情况的问卷",
    questions: [ ],
    title: "关于在校大学生XX情况的问卷"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d3d3e6d3257a1b28389"),
    title: "东大标准收集表1",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:47:41.14Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d403e6d3257a1b2838b"),
    title: "东大标准收集表2",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:47:44.276Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d433e6d3257a1b2838d"),
    title: "东大标准收集表3",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:47:47.357Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d463e6d3257a1b2838f"),
    title: "东大标准收集表4",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:47:50.17Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d493e6d3257a1b28391"),
    title: "东大标准收集表5",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:47:53.043Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d733e6d3257a1b28393"),
    title: "东大标准收集表12",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:35.842Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d753e6d3257a1b28395"),
    title: "东大标准收集表11",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:37.084Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d763e6d3257a1b28397"),
    title: "东大标准收集表10",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:38.155Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d773e6d3257a1b28399"),
    title: "东大标准收集表9",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:39.114Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d783e6d3257a1b2839b"),
    title: "东大标准收集表8",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:40.078Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d793e6d3257a1b2839d"),
    title: "东大标准收集表7",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:41.056Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("64980d793e6d3257a1b2839f"),
    title: "东大标准收集表6",
    description: "东北大学学生基本信息手机，包含姓名班级学号",
    questions: [ ],
    createTime: ISODate("2023-06-25T09:48:41.959Z")
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c43877347bb764f1cbd3e"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c43f0a175fd52693a4007"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c44788e0dc96d08b85225"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c44e7dc1f60372f27a77b"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c45b88b39870ab7cc365c"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c46bbf8e4b554bf484a23"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c46ef7d1c0e6fd6f2894a"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c476f6488fe140e7dc047"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c476f6488fe140e7dc048"),
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c4c5494e4415fd0bad94a"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
db.getCollection("template").insert([ {
    _id: ObjectId("649c58300caf1e182becbab5"),
    title: "test1",
    _class: "tgkt.togaform.entity.Template"
} ]);
