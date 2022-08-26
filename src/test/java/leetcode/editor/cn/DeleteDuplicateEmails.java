/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
//表: Person 
//
// 
//+-------------+---------+
//| Column Name | Type    |
//+-------------+---------+
//| id          | int     |
//| email       | varchar |
//+-------------+---------+
//id是该表的主键列。
//该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。
// 
//
// 
//
// 编写一个SQL查询来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。 
//
// 以 任意顺序 返回结果表。 
//
// 查询结果格式如下所示。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//Person 表:
//+----+------------------+
//| id | email            |
//+----+------------------+
//| 1  | john@example.com |
//| 2  | bob@example.com  |
//| 3  | john@example.com |
//+----+------------------+
//输出: 
//+----+------------------+
//| id | email            |
//+----+------------------+
//| 1  | john@example.com |
//| 2  | bob@example.com  |
//+----+------------------+
//解释: john@example.com重复两次。我们保留最小的Id = 1。 
// Related Topics 数据库 
// 👍 483 👎 0


//There is no code of Java type for this problem