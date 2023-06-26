# 1. 引言

# MongoDB数据结构设计

Template

| 字段名         | 类型       | 说明     |
|-------------|----------|--------|
| title       | string   | 模板名称   |
| createTime  | string   | 创建日期   |
| description | string   | 模板描述   |
| questions   | string[] | 问题Id集合 |

Quesnaire

| 字段名         | 类型       | 说明                  |
|-------------|----------|---------------------|
| title       | string   | 问卷标题                |
| createTime  | string   | 问卷创建日期              |
| surveyType  | string   | 问卷类型                |
| description | string   | 问卷描述                |
| questions   | string[] | 问题ID的集合             |
| roles       | number[] | 问卷面向人群（见enum_role表） |

Question

| 字段名             | 类型                | 说明                         |
|-----------------|-------------------|----------------------------|
| title           | string            | 问题标题                       |
| required        | boolean           | 是否必答                       |
| description     | string            | 问题描述                       |
| answerType      | number            | 问题类型ID(见enum_answer_type表) |
| answerSelection | AnswerSelection[] | 答案选项集合（单选、多选、矩阵）           |

=>AnswerSelection

| 字段名   | 类型     | 说明            |
|-------|--------|---------------|
| key   | string | 选项标识（ABC）或矩阵列 |
| value | string | 选项内容或者矩阵行     |

Answer

| 字段名        | 类型         | 说明     |
|------------|------------|--------|
| userId     | string     | 回答用户Id |
| answerTime | string     | 填写时间   |
| quesnaire  | string     | 问卷Id   |
| answers    | AnswerItem | 回答集合   |

=> AnswerItem

| 字段名        | 类型              | 说明   |
|------------|-----------------|------|
| questionId | string          | 问题Id |
| answer     | AnswerSelection | 答案内容 |