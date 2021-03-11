package com.yangxi.boot.sample.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象克隆工具类
 * @author yangxi
 *
 */
public class ObjectCloneUtil {

	/**
	 * 转换集合-浅克隆
	 * @param sourceList 源集合
	 * @param targetClazz 目标集合元素类型
	 * @return 转换后的集合
	 */
	public static <T> List<T> convertList(
            List<? extends AbstractObject> sourceList, Class<T> targetClazz) {
		if(sourceList == null) {
			return null;
		}

		List<T> targetList = new ArrayList<T>();
		for(AbstractObject sourceObject : sourceList) {
			targetList.add(sourceObject.clone(targetClazz));
		}

		return targetList;
	}

	/**
	 * 转换集合-深度克隆
	 * @param sourceList 源集合
	 * @param targetClazz 目标集合元素类型
	 * @param cloneDirection 深度分页参数 @See CloneDirection.java
	 * @return 转换后的集合
	 */
	public static <T> List<T> convertList(List<? extends AbstractObject> sourceList,
                                          Class<T> targetClazz, Integer cloneDirection) {
		if(sourceList == null) {
			return null;
		}

		List<T> targetList = new ArrayList<T>();
		for(AbstractObject sourceObject : sourceList) {
			targetList.add(sourceObject.clone(targetClazz, cloneDirection));
		}

		return targetList;
	}

	/**
	 * 转换集合-浅克隆
	 * @param sourcePage 源分页集合
	 * @param targetClazz 目标集合元素类型
	 * @return 转换后的集合
	 */
	public static <T> IPage<T> convertPage(
			IPage<? extends AbstractObject> sourcePage, Class<T> targetClazz) {
		if(sourcePage == null) {
			return null;
		}
		List<? extends AbstractObject> sourceList = sourcePage.getRecords();
		List<T> targetList = convertList(sourceList, targetClazz);
		IPage<T> targetPage = new Page<>(sourcePage.getCurrent(), sourcePage.getSize(), sourcePage.getTotal(), sourcePage.isSearchCount());
		targetPage.setRecords(targetList);
		return targetPage;
	}

	/**
	 * 转换集合-深度克隆
	 * @param sourcePage 源分页集合
	 * @param targetClazz 目标集合元素类型
	 * @param cloneDirection 深度分页参数 @See CloneDirection.java
	 * @return 转换后的集合
	 */
	public static <T> IPage<T> convertPage(IPage<? extends AbstractObject> sourcePage,
										   Class<T> targetClazz, Integer cloneDirection) {
		if(sourcePage == null) {
			return null;
		}
		List<? extends AbstractObject> sourceList = sourcePage.getRecords();
		List<T> targetList = convertList(sourceList, targetClazz, cloneDirection);
		IPage<T> targetPage = new Page<>(sourcePage.getCurrent(), sourcePage.getSize(), sourcePage.getTotal(), sourcePage.isSearchCount());
		targetPage.setRecords(targetList);
		return targetPage;
	}

}
