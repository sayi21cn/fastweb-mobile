1.����Tomcat MSM�ļ��ɻ�����
	���ֶ�����mem-clu1.bat mem-clu2.bat mem-clu3.bat 
2.������Ⱥ
	�ֶ�����tomcat1.bat tomcat2.bat
3.���Լ�ȺSession,Sessionһ�£���Ⱥ����OK
	http://localhost:8180/examples/jsp/sessions/my.jsp
	http://localhost:8280/examples/jsp/sessions/my.jsp
3.����nginx.bat,���Է���session��tomcat��sessionһ��
	http://localhost/examples/jsp/sessions/my.jsp
4.ѹ������
  #.�Լ��ʼǱ���6G�ڴ棬ѹ�����ԣ�����3000�ް�
  #.���伯Ⱥ��
	����tomcat-2��tomcat-3,����server.xml�˿ڲ���ͻ��
	����nginx����
	upstream backend {
	ip_hash;
	server 127.0.0.1:8180 weight=10;
	server 127.0.0.1:8280 weight=10;
	server 127.0.0.1:8380 weight=10;
}

