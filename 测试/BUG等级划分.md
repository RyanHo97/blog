1崩溃型的  2级严重 3 一般 4 次要

P0
>> 描述

1、必现且阻塞流程的Bug；

2、偶现概率 >= 50%，影响功能正常使用的Bug；

>> Example

1、必现的软件崩溃；

2、影响主流程；

3、严重的数值错误；

4、其他导致无法测试的错误，如接口500；

>> Comments

1、影响上线；

2、8小时内，必须在当天解决；

P1
>> 描述

1、必现且影响较大，但不阻塞流程的Bug；

2、偶现概率 < 50%，影响功能正常使用的Bug；

>> Example

1、只在某特定操作下才出现的较严重Bug

2、严重的界面错误

>> Comments

1、影响上线；

2、24小时内，且必须在进入第二轮测试前解决；

（P0/P1不好判断时，可通过期望的解决时间来判断）

P2
>> 描述

1、普通的功能Bug，除其他优先级之外的Bug

>> Example

1、与需求不符的普通Bug

>> Comments

1、影响上线；

2、2天内，必须在进入Prod前解决；

P3
>> 描述

1、低优先级Bug，不影响上线；

2、偶现概率 < 5% 的Bug；

3、界面/边界/兼容性/建议性/易用性Bug

>> Example

1、UI小问题；

2、低频且影响不大的问题；

>> Comments

1、不影响上线；

2、可以放到下个版本解决。
