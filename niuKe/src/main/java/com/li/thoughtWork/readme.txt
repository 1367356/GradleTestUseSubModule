4*5的道路网络网格，需要用[2*4+1][2*5+1]的渲染网格。
我们创建一个该大小9*11的数组：在每个位置上放[W]

1,2的角标在渲染网格中的位置为[1*2+1][2*2+1],角标从0开始。
于是我们读取道路网络的位置：
0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
用;将其分开，  再将各个相邻的网格用空格分为两个网格。 将其位置置为[R]

检查输入的有效性判断：
1：格式转化异常，try catch 如果有数字转换异常，打印 ”Invalid number format . ”
2：数字超出预定范围：数字超出了允许的范围，例如为负数等。此时，该函数的输出为字符串
  ”Number out of range.”


  数字应大于0，行小于道路网格行的最大值，列小于道路网格列的最大值。两行都要判断。


3：格式错误：输入命令的格式不符合约定。此时，该函数的输出为字符串 ”Incorrect command
            format.”

  判断字符串截取的数组，是否符合指定格式。可以用正则判断。
  3行不行。1行可以，说明无连接网格。

4：连通性错误：如果两个网格无法连通，则属于这种错误。此时，该函数的输出为字符串 ”Maze
  format error.”

   连通性：就是只有一个角标变化1，才可以。
