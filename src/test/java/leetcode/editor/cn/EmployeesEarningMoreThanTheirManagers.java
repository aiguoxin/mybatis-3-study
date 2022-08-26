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
//表：Employee 
//
// 
//+-------------+---------+
//| Column Name | Type    |
//+-------------+---------+
//| id          | int     |
//| name        | varchar |
//| salary      | int     |
//| managerId   | int     |
//+-------------+---------+
//Id是该表的主键。
//该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
// 
//
// 
//
// 编写一个SQL查询来查找收入比经理高的员工。 
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
//Employee 表:
//+----+-------+--------+-----------+
//| id | name  | salary | managerId |
//+----+-------+--------+-----------+
//| 1  | Joe   | 70000  | 3         |
//| 2  | Henry | 80000  | 4         |
//| 3  | Sam   | 60000  | Null      |
//| 4  | Max   | 90000  | Null      |
//+----+-------+--------+-----------+
//输出: 
//+----------+
//| Employee |
//+----------+
//| Joe      |
//+----------+
//解释: Joe 是唯一挣得比经理多的雇员。 
// Related Topics 数据库 
// 👍 487 👎 0


//There is no code of Java type for this problem