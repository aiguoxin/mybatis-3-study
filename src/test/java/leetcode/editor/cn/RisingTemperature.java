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
//
// 
// 表： Weather 
//
// 
//+---------------+---------+
//| Column Name   | Type    |
//+---------------+---------+
//| id            | int     |
//| recordDate    | date    |
//| temperature   | int     |
//+---------------+---------+
//id 是这个表的主键
//该表包含特定日期的温度信息 
//
// 
//
// 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。 
//
// 返回结果 不要求顺序 。 
//
// 查询结果格式如下例。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//Weather 表：
//+----+------------+-------------+
//| id | recordDate | Temperature |
//+----+------------+-------------+
//| 1  | 2015-01-01 | 10          |
//| 2  | 2015-01-02 | 25          |
//| 3  | 2015-01-03 | 20          |
//| 4  | 2015-01-04 | 30          |
//+----+------------+-------------+
//输出：
//+----+
//| id |
//+----+
//| 2  |
//| 4  |
//+----+
//解释：
//2015-01-02 的温度比前一天高（10 -> 25）
//2015-01-04 的温度比前一天高（20 -> 30） 
// 
// 
// Related Topics 数据库 
// 👍 288 👎 0


//There is no code of Java type for this problem