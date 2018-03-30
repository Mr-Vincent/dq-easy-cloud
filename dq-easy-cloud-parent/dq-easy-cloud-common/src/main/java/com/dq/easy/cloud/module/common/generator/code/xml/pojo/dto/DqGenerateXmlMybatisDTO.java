package com.dq.easy.cloud.module.common.generator.code.xml.pojo.dto;

import java.util.List;

import com.dq.easy.cloud.module.common.collections.utils.DqCollectionsUtils;
import com.dq.easy.cloud.module.common.generator.code.xml.constant.DqCodeGenerateXmlConstant.DqTableColumnKey;
import com.dq.easy.cloud.module.common.string.constant.DqStringConstant.DqSymbol;
import com.dq.easy.cloud.module.common.string.utils.DqStringUtils;

/**
 * 
 * <p>
 * mybatis的xml数据传输对象
 * </p>
 *
 * @author daiqi
 * 创建时间    2018年3月29日 下午12:47:38
 */
public class DqGenerateXmlMybatisDTO extends DqGenerateXmlBaseDTO{
	/** 命名空间---即dao类完整类型 */
	private String namespace;
	/** 表名 */
	private String tableName;
	/** 表明简写 */
	private String tableSimpleName;
	/** 完整的类类型---持久化类 */
	private String fullClassTypeDO;
	/** 简称的类类型---持久化类 */
	private String simpleClassTypeDO;
	/** 主键 */
	private DqGenerateXmlMybatisData primaryKey;
	/** 数据列表 */
	private List<DqGenerateXmlMybatisData> datas;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableSimpleName() {
		return tableSimpleName;
	}

	public void setTableSimpleName(String tableSimpleName) {
		this.tableSimpleName = tableSimpleName;
	}

	public String getFullClassTypeDO() {
		return fullClassTypeDO;
	}

	public void setFullClassTypeDO(String fullClassTypeDO) {
		this.fullClassTypeDO = fullClassTypeDO;
	}

	public String getSimpleClassTypeDO() {
		return simpleClassTypeDO;
	}

	public void setSimpleClassTypeDO(String simpleClassTypeDO) {
		this.simpleClassTypeDO = simpleClassTypeDO;
	}

	public List<DqGenerateXmlMybatisData> getDatas() {
		return datas;
	}

	public void setDatas(List<DqGenerateXmlMybatisData> datas) {
		this.datas = datas;
	}
	
	public DqGenerateXmlMybatisData getPrimaryKey() {
		if (primaryKey != null){
			return primaryKey;
		}
		for (DqGenerateXmlMybatisData data : datas) {
			if (DqTableColumnKey.isPrimary(data.getColumnKey())) {
				primaryKey = data;
			}
		}
		return primaryKey;
	}

	public void setPrimaryKey(DqGenerateXmlMybatisData primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public String buildDatasStr() {
		if (DqCollectionsUtils.isEmpty(datas)) {
			return null;
		}
		StringBuilder sb = DqStringUtils.newStringBuilderDefault();
		for (int i = 0 ; i < datas.size() ; ++i) {
			DqGenerateXmlMybatisData data = datas.get(i);
			if (DqStringUtils.isNotEmpty(tableSimpleName)) {
				sb.append(tableSimpleName);
			} else {
				sb.append(tableName);
			}
			sb.append(DqSymbol.STOP).append(data.getColunmName());
			if (i < datas.size() - 1) {
				sb.append(DqSymbol.COMMA);
			}
		}
		return sb.toString();
	}

}
