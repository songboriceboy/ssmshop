
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
                  //�ַ���ת����
                  int nDistance = Integer.parseInt(strDistance);//"12"--->12
                  if (nDirection == 0)//�����ߣ���x�����������
                  {
                      int k = 0;
                      for (k = 0; k < nDistance&&jPos + k < 50; k++)
                      {
                          //2.�жϱʵĳ����������Ƿ��ڵذ������ºۼ���0�Ƿ���1��
                          if (nPen == 1)
                          {
                              arrFloor[iPos][jPos+k] = 1;
                          }
                      }

                      jPos = jPos + k - 1; // 1.�ı��ڹ��λ��

                      //    1.�ı��Լ���λ��
                      //    2.�жϱʵĳ����������Ƿ��ڵذ������ºۼ���0�Ƿ���1��
                      //    3.Ҫע�ⲻҪ����
                  }
                  else if (nDirection == 1)//�����ߣ�
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && iPos + k < 50; k++)
                      {
                          //2.�жϱʵĳ����������Ƿ��ڵذ������ºۼ���0�Ƿ���1��
                          if (nPen == 1)
                          {
                              arrFloor[iPos + k][ jPos] = 1;
                          }
                      }

                      iPos = iPos + k - 1;
                  }
                  else if (nDirection == 2)//������
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && jPos - k >= 0; k++)
                      {
                          //2.�жϱʵĳ����������Ƿ��ڵذ������ºۼ���0�Ƿ���1��
                          if (nPen == 1)
                          {
                              arrFloor[iPos][ jPos - k] = 1;
                          }
                      }

                      jPos = jPos - (k-1) ;
                  }
                  else //(nDirection == 3)//�����ߣ���y��ĸ�������
                  {
                      int k = 0;
                      for (k = 0; k < nDistance && iPos - k >=0; k++)
                      {
                          //2.�жϱʵĳ����������Ƿ��ڵذ������ºۼ���0�Ƿ���1��
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
        	    else if ("3".equals(strCommand))//����ת
                {
                    nDirection++;
                    if (nDirection > 3)
                        nDirection = 0;
                }
                else if ("4".equals(strCommand))//����ת
                {
                    nDirection--;
                    if(nDirection<0)
                        nDirection = 3;
                }
        	  else if("6".equals(strCommand))
        	  {
        		  for (int i = 0; i < 50; i++)//�ڼ���
                  {
                      for (int j = 0; j < 50; j++)//�ڼ���
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
