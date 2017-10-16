package com.ANT.Library.Interface;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * ����ӿڱ�ʾһ������DAO�ӿ�
 * @param <K> ��ʾ����
 * @param <V> ��ʾҪ�����Ķ���
 */
public interface IDAO<K,V> {
    /**
     * ʵ���������Ӳ���
     * @param vo ��ʾҪִ�в����Ķ���
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws SQLException
     */
    public boolean doCreate(V vo)throws SQLException;

    /**
     * ʵ�����ݲ���
     * @param vo ��ʾҪִ�и��¶���
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws SQLException
     */
    public boolean doUpdate(V vo) throws SQLException;

    /**
     * ʵ����������ɾ��
     * @param ids ��ʾҪִ��ɾ�������ݼ���
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws SQLException
     */
    public boolean doRemove(Set<?> ids)throws SQLException;

    /**
     * �����û��ṩ��id���в�ѯ
     * @param id ��ʹ��ִ�в�ѯ����
     * @return ��ѯ�ɹ����ظ��������еļ�¼��ʧ�ܷ���null
     * @throws SQLException
     */
    public V findById(K id)throws SQLException;

    /**
     * ʵ������ȫ����ѯ
     * @return �ɹ�����ȫ�����ݣ�ʧ�ܷ���null
     * @throws SQLException
     */
    public List<V> findAll()throws SQLException;

    /**
     * ʵ�����ݷ�ҳ����
     * @param column ��ʾҪִ�в�ѯ��
     * @param keyWord ��ʾ��ѯ�ؼ���
     * @param currentPage ��ʾ��ǰҳ
     * @param lineSize ��ʾÿҳ��ʾ��¼��
     * @return �ɹ������������������ݣ�ʧ�ܷ���null
     * @throws SQLException
     */
    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer  lineSize)throws SQLException;

    /**
     * ʵ��������ͳ�Ʋ���
     * @param column ��ʾҪִ��ͳ����
     * @param keyWord ��ʾͳ�Ʋ�ѯ�ؼ���
     * @return �ɹ�������������ʧ�ܷ��� 0
     * @throws SQLException
     */
    public Integer getAllCount(String column,String keyWord)throws SQLException;
}
