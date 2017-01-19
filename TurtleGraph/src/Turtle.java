
public class Turtle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrFloor = new int[50][50];
		 
		  int nPen = 0;
		  int nDirection = 0;
          int iPos = 0;
          int jPos = 0;
         // String[] strCommands = { "2", "5,12", "3", "5,12", "3", "5,12", "3", "5,12", "1", "6", "9" };
          String[] strCommands = { "2", "5,20", "3", "3", "1", "5,10", "2", "4", "5,10", "4", "5,10", "3", "3", "5,20", "1", "6", "9" };
          for(int c = 0; c < strCommands.length; c++)
          {
              String[] arrCommand = strCommands[c].split(",");
              String strCommand = arrCommand[0];
        	  if("1".equals(strCommand))
        	  {
        		  nPen = 0;
        	  }
        	  else if ("5".equals(strCommand))
              {
        		  String strDistance = arrCommand[1];
                  //字符串转数字
                  int nDistance = Integer.parseInt(strDistance);//"12"--->12
                  if (nDirection == 0)//向右走，向x轴的正方向走
                  {
                      int k = 0;
                      for (k = 0; k < nDistance&&jPos + k < 50; k++)
                      {
                          //2.判断笔的朝向，来决定是否在地板上留下痕迹（0是否变成1）
                          if (nPen == 1)
                          {
                              arrFloor[iPos][jPos+k] = 1;
                          }
                      }

                      jPos = jPos + k - 1; // 1.改变乌龟的位置

                      //    1.改变自己的位置
                      //    2.判断笔的朝向，来决定是否在地板上留下痕迹（0是否变成1）
                      //    3.要注意不要出格。
                  }
                  else if (nDirection == 1)//向下走，
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && iPos + k < 50; k++)
                      {
                          //2.判断笔的朝向，来决定是否在地板上留下痕迹（0是否变成1）
                          if (nPen == 1)
                          {
                              arrFloor[iPos + k][ jPos] = 1;
                          }
                      }

                      iPos = iPos + k - 1;
                  }
                  else if (nDirection == 2)//向左走
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && jPos - k >= 0; k++)
                      {
                          //2.判断笔的朝向，来决定是否在地板上留下痕迹（0是否变成1）
                          if (nPen == 1)
                          {
                              arrFloor[iPos][ jPos - k] = 1;
                          }
                      }

                      jPos = jPos - (k-1) ;
                  }
                  else //(nDirection == 3)//向上走，向y轴的负方向走
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && iPos - k >=0; k++)
                      {
                          //2.判断笔的朝向，来决定是否在地板上留下痕迹（0是否变成1）
                          if (nPen == 1)
                          {
                              arrFloor[iPos - k][ jPos] = 1;
                          }
                      }

                      iPos = iPos - (k-1);
                  }
            


              }
        	  else if("2".equals(strCommand))
        	  {
        		  nPen = 1;
        	  }
        	    else if ("3".equals(strCommand))//向右转
                {
                    nDirection++;
                    if (nDirection > 3)
                        nDirection = 0;
                }
                else if ("4".equals(strCommand))//向左转
                {
                    nDirection--;
                    if(nDirection<0)
                        nDirection = 3;
                }
        	  else if("6".equals(strCommand))
        	  {
        		  for (int i = 0; i < 50; i++)//第几行
                  {
                      for (int j = 0; j < 50; j++)//第几列
                      {
                          System.out.print(arrFloor[i][j]);
                      }
                      System.out.println();
                  }
        	  }
        	  else //("9".equals(strCommand))
        	  {
        		  return;
        	  }
          }
	}

}
