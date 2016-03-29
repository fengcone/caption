package com.fengcone.caption.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.fengcone.caption.domain.Package;
import com.fengcone.caption.mapper.PackageMapper;
import com.fengcone.caption.vo.CaptionVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ctx.xml" })
public class PackageDaoTest {
	@Autowired
	PackageMapper packageDao;
	private ObjectMapper mapper = new ObjectMapper();
	@Test
	public void testInser2DB() throws Exception{
		File file0 = new File("D:\\CaptionData\\Lucy\\OK");
		File[] files = file0.listFiles();
		for (File file : files) {
			String json = file2JsonStr(file);
			List<CaptionVo> vos = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, CaptionVo.class));
			for (CaptionVo vo : vos) {
				List<Package> packages = vo.getPackages();
				for (Package package1 : packages) {
					String english = package1.getEnglish();
					String chinese = package1.getChinese();
					if (!StringUtils.isEmpty(english)&& !StringUtils.isEmpty(chinese)) {
						packageDao.insert(package1);
					}
				}
			}
		}
	}
	
	private String file2JsonStr(File file) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = "";
		String result = "";
		while ((str = reader.readLine())!=null) {
			result = result+ str.trim();
		}
		reader.close();
		return result;
	}
}
