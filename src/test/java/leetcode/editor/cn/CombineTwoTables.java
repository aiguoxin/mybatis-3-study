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
//| 列名         | 类型     |
//+-------------+---------+
//| PersonId    | int     |
//| FirstName   | varchar |
//| LastName    | varchar |
//+-------------+---------+
//personId是该表的主键列。
//该表包含一些人的ID和他们的姓和名的信息。
// 
//
// 
//
// 表: Address 
//
// 
//+-------------+---------+
//| 列名         | 类型    |
//+-------------+---------+
//| AddressId   | int     |
//| PersonId    | int     |
//| City        | varchar |
//| State       | varchar |
//+-------------+---------+
//addressId是该表的主键列。
//该表的每一行都包含一个ID = PersonId的人的城市和州的信息。
// 
//
// 
//
// 编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和状态。如果 personId 的地址不在 Address 表中，则报告为空 null 。
// 
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
//Person表:
//+----------+----------+-----------+
//| personId | lastName | firstName |
//+----------+----------+-----------+
//| 1        | Wang     | Allen     |
//| 2        | Alice    | Bob       |
//+----------+----------+-----------+
//Address表:
//+-----------+----------+---------------+------------+
//| addressId | personId | city          | state      |
//+-----------+----------+---------------+------------+
//| 1         | 2        | New York City | New York   |
//| 2         | 3        | Leetcode      | California |
//+-----------+----------+---------------+------------+
//输出: 
//+-----------+----------+---------------+----------+
//| firstName | lastName | city          | state    |
//+-----------+----------+---------------+----------+
//| Allen     | Wang     | Null          | Null     |
//| Bob       | Alice    | New York City | New York |
//+-----------+----------+---------------+----------+
//解释: 
//地址表中没有 personId = 1 的地址，所以它们的城市和州返回null。
//addressId = 1 包含了 personId = 2 的地址信息。 
// Related Topics 数据库 
// 👍 1090 👎 0


//There is no code of Java type for this problem