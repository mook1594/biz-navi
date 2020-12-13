package com.mook1594.biznavi.common.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mook1594.biznavi.common.utils.DateTimeUtils;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractCommonDto {

	@Getter
	protected LocalDateTime created;

	public AbstractCommonDto() {
		this.created = DateTimeUtils.now();
	}

	public AbstractCommonDto(final LocalDateTime created) {
		this.created = Objects.nonNull(created) ? created : DateTimeUtils.now();
	}
}
