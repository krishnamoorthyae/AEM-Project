package com.vodafone.core.models;

import java.util.Collections;
import java.util.List;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, resourceType = "vodafone/components/content/iconlist", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION, selector = ExporterConstants.SLING_MODEL_SELECTOR, options = {
		@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
		@ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true")
})
public class IconListModel{
	

	@SlingObject
	private Resource resource;
	

	@ChildResource(name = "tabsfield")
	private List<Resource> tabsfield;

	

	public List<Resource> getTabsField() {
		return Collections.unmodifiableList(tabsfield);
	}

	public String  getCount() {
		return String.valueOf(tabsfield.size());
	}
}
