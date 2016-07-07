/****************************************************************
 *文件名: 类名.java <br>
 *版本: <br>
 *描述: 相关描述<br>
 *版权所有: <br>
 *创建者: 刘源 <br>
 *创建日期: 2016年7月7日 <br>
 *修改者: 刘源<br>
 *修改日期: 2016年7月7日<br>
 *修改说明: 修改说明<br>
 ****************************************************************/

package org.test.reconnect;

import org.junit.Test;

/**
 * 类的相关描述
 */

public class Test1 {

	@Test
	public void haha() throws InterruptedException {
		Client client = new Client();
		client.connect("192.168.2.22", 8000);
	
		while (true) {
				
		}
	}

}
