https://fastweb-mobile.googlecode.com/svn/trunk/05.common-tools/fulltext/

http://127.0.0.1:8983/solr/
http://127.0.0.1:8983/solr/browse


1.���ø���,�����Լ���·������֮�������������
05.common-tools\fulltext\apache-tomcat-7.0.47\webapps\solr\WEB-INF\web.xml
���� 
<env-entry>
       
	<env-entry-name>solr/home</env-entry-name>
       
	<env-entry-value>I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home</env-entry-value>
       	<env-entry-type>java.lang.String</env-entry-type>
    
</env-entry>
����
   <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/contrib/extraction/lib" regex=".*\.jar" />
  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/dist/" regex="solr-cell-\d.*\.jar" />

  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/contrib/clustering/lib/" regex=".*\.jar" />
  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/dist/" regex="solr-clustering-\d.*\.jar" />

  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/contrib/langid/lib/" regex=".*\.jar" />
  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/dist/" regex="solr-langid-\d.*\.jar" />

  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/contrib/velocity/lib" regex=".*\.jar" />
  <lib dir="I:/env-myopensource/fastweb-mobile/05.common-tools/fulltext/solr-home/bin/dist/" regex="solr-velocity-\d.*\.jar" />

2.���ķִ�������ɣ�fieldtype:text��
���Ե�ַhttp://localhost:8983/solr/#/collection1/analysis

�ʿ���չIKAnalyzer.cfg.xml���ѹ��ʿ⣬googleƴ���ʿ⣬�Զ�����չ�ʿ⣩
<properties>  
	<comment>IK Analyzer ��չ����</comment>
	<!--�û����������������Լ�����չ�ֵ� -->
	<entry key="ext_dict">SogouLabDic.dic;mygoogle.dic;ext.dic;</entry> 
	
	<!--�û����������������Լ�����չֹͣ���ֵ�-->
	<entry key="ext_stopwords">stopword.dic;</entry> 
	
</properties>


3.�����ĵ�����
���Ե�ַhttp://localhost:8983/solr/#/collection1/documents

4.��ѯ����
http://localhost:8983/solr/#/collection1/query

5.���ݿⶨʱ��������

solrconfig.xml
<requestHandler name="/dataimport" class="org.apache.solr.handler.dataimport.DataImportHandler">
	<lst name="defaults">
		<str name="config">data-config.xml</str>
	</lst>
</requestHandler>


data-config.xml
<dataConfig>
    <dataSource driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@127.0.0.1:1528:orcl" user="gbjwo" password="gbjwo"/>
    <document>
		<!--transformer="ClobTransformer" 
		deltaImportQuery="select * from VIEW_DETAIL where DETAIL_ID='${dih.delta.DETAIL_ID}'"
        deltaQuery="select DETAIL_ID from VIEW_DETAIL where PUBLISH_TIME &gt; to_date('${dih.last_index_time}','yyyy-mm-dd hh:mi:ss')"
		-->
        <entity name="contact" query="select pkid id,name from contact">
            <field column="TEXT" name="id"/>
            <field column="TEXT" name="name"/>
			<!--clob="true"-->
		</entity>
    </document>
</dataConfig>

��������
http://localhost:8983/solr/dataimport?command=full-import&commit=true 
��������
http://localhost:8983/solr/dataimport?command=delta-import&commit=true


todo ����
1.solr����������ʾSuggest
2.solr ��ƴ��������ƴ������ĸ������֧��
3.��Ʒ���ʹ��SOLR
a.��������滮���
a1 ���ƺ�ҵ��ģ��
a2 ���ƺ������ṹ
a3 ���ƺ���������
b.������������
������������Ĺ滮������solr��schema.xml�������ļ���
c.������������ʱ��������
ͨ�����������ӿڽ��������Ĺ�������¡�
d.����
ͨ�����������ӿڽ���������
e.����ά���͸Ľ�
