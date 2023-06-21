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

 Date: 22/06/2023 06:03:33
*/


// ----------------------------
// Collection structure for answer
// ----------------------------
db.getCollection("answer").drop();
db.createCollection("answer");

// ----------------------------
// Documents of answer
// ----------------------------

// ----------------------------
// Collection structure for question
// ----------------------------
db.getCollection("question").drop();
db.createCollection("question");

// ----------------------------
// Documents of question
// ----------------------------

// ----------------------------
// Collection structure for questionaire
// ----------------------------
db.getCollection("questionaire").drop();
db.createCollection("questionaire");

// ----------------------------
// Documents of questionaire
// ----------------------------

// ----------------------------
// Collection structure for template
// ----------------------------
db.getCollection("template").drop();
db.createCollection("template");

// ----------------------------
// Documents of template
// ----------------------------
