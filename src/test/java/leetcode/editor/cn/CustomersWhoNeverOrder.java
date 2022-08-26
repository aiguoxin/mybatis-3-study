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
//某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。 
//
// Customers 表： 
//
// +----+-------+
//| Id | Name  |
//+----+-------+
//| 1  | Joe   |
//| 2  | Henry |
//| 3  | Sam   |
//| 4  | Max   |
//+----+-------+
// 
//
// Orders 表： 
//
// +----+------------+
//| Id | CustomerId |
//+----+------------+
//| 1  | 3          |
//| 2  | 1          |
//+----+------------+
// 
//
// 例如给定上述表格，你的查询应返回： 
//
// +-----------+
//| Customers |
//+-----------+
//| Henry     |
//| Max       |
//+-----------+
// 
// Related Topics 数据库 
// 👍 289 👎 0


//There is no code of Java type for this problem