20130706
��̬������ʾ��Ϣ��
<script type="text/html" id="p-template">
	<div data-role="popup" id="popupBasic1">
		<h1>{{title}}</h1>
		<p>{{msg}}</p>
	</div>  
</script>

<div  id="p-view">
</div>

$(document).on('pageshow','[data-role=page]', function(){
	//��̬������ʾ�򣻴�����ʾ����ʾ��ʾ��
	template=$('#p-template');
	data={msg:"�����Ҷ��Ƶ���ʾ��Ϣ",title:"��ʾ��Ϣ!"};
	pupopview= Mustache.to_html(template.html(),data).replace(/^\s*/mg, '');
	$('#p-view').empty().append(pupopview).trigger('create');//.popup('refresh');
	$('#popupBasic1').popup();
	$('#popupBasic1').popup('open');
});

JS��̬ҳ�����ҳ����ת����ˢ��
	 ����Ԫ�� rel= external  actives
     
    

20130621
    ����
    �����µ�html5ǰ�˿�ܣ�AppFramework(ԭjqMobi,css����������)�������jquerymobile���������ģ���html5 and css3 ���ɵġ�
    ʹ��mustacheģ�����涯̬���ݼ��ء�
    ���˵�����߶ȵ���(css)��
    ��Ԫ�������
	���Ԫ���л���


Ŀ�꣺ǰ�˻�������Ŀ��ٿ�����ƽ̨����������߼����������ڷ����RestApi��

=�ƶ��������ٿ���ƽ̨=
==����ĵ�==

==rest-api==
spring rest+spring data+mongodb
  #.����MongodbΪ�ײ����ݿ⣺�������������䣻
  #.����Mongodb��Ⱥ��֧�Ŵ����������󲢷�ʵʱ��ѯ��������չ��
  #.����SpringMongodb�򻯿������򵥵����˷�ָ��
  #.����SpringRest�ṩJSON�������֧�ָ���ת����
  #.�ṩ�������ϡ��������ġ�����JSONP��֧�֣�
  #.�����˴���������ѹ�����ԣ��������������ã�
  #.�������ʵ����

==client==

===��׿===
PhoneGap
===IOS===
PhoneGap
===HTML5===
{{{���ٿ�����ǰ�˼ܹ���רҵ���ֹ������ٿ����������ÿ�����View��}}}

  #.���������İ�׿��IOS�������
  #.JQueryMobile���������棻
  #.ʹ��ģ������Mustacheת��JSON���ݣ���̬���JQueryMobile�����
  #.ʹ��Dreamweaver��ģ��Ϳ����HTML5����ĸ��ã�
  #.���볣�õ�ͼ��չ�ֹ��ߣ�


==���ʵ��(todo)==
  #.Mongodb���Ż����ã�Mongodb�ķ�Ƭ��Ⱥ�İ�װ��
  #.Nginx and Keepalived ������⣻
  #.Tomcat�Ż����ã�Tomcat��Ⱥ����Session MSM(memcached)���ã�
  #.fastweb-mobile��־�ɼ�����չ�֣�
  #.Spring aop asyc jmx ��ʹ��ʾ����
 
==��Ⱥ==
Tomcat�Ż����ã�Tomcat��Ⱥ����Session MSM(memcached)���ã�
  #.����Tomcat MSM�ļ��ɻ�����
	���ֶ�����mem-clu1.bat mem-clu2.bat mem-clu3.bat 
  #.������Ⱥ
	�ֶ�����tomcat1.bat tomcat2.bat
  #.���Լ�ȺSession,Sessionһ�£���Ⱥ����OK
	http://localhost:8180/rest-api/examples/jsp/sessions/my.jsp
	http://localhost:8280/rest-api/examples/jsp/sessions/my.jsp
  #.����nginx.bat,���Է���session��tomcat��sessionһ��
	http://localhost/rest-api/examples/jsp/sessions/my.jsp
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

==��־�ɼ���mongodb==
1.������־��ʽ
log_format  json  '{'
                    '"remote_addr": "$remote_addr",'
                    '"remote_user": "$remote_user",'
                    '"time_local": "$time_local",'
                    '"request": "$request",'
                    '"status": $status,'
                    '"body_bytes_sent": $body_bytes_sent,'
                    '"http_referer": "$http_referer",'
                    '"http_user_agent": "$http_user_agent",'
                    '"http_x_forwarded_for": "$http_x_forwarded_for"'
                  '}';

2.��������ļ�����
access_log logs/access.log.json json;

3.���뵽mongodb
more log2mongodb.sh 
for i in `find /var/log/nginx -name "access.log*.gz"`
do
#echo $i |awk -F= '{print $1}'
filename=`echo $i|awk -F= '{print $1}'`
mkdir -p /var/log/nginx/done-2mongodb/
gunzip $filename   
lname=${filename%.*}
echo $lname
echo 'todo import 2 mongodb '
mongoimport -d admin -c weblog -port 40000  $lname
mv  $lname  /var/log/nginx/done-2mongodb/
echo 'done $lname'
done

#��ʱ����
#���ִ��Ȩ��
#chmod +x log2mongodb.sh 
#ÿ��0��01��������
#01 00 * * * /·��/log2mongodb.sh 

==һ����������������һ������������==
  #.windows ������ php + nginx( �Ѿ��Ƴ������mysmarty��Ŀ )
  


==HTML5��Ŀ����==
  #.����·����http://localhost/
  #.��Դѹ��CSS JS HTML JSON

==һ����������������һ������������==
  #.һ����������������start.bat
  #.һ��������������stop.bat


==��Ŀ��ַ==
https://code.google.com/p/fastweb-mobile/ 