package com.mook1594.biznavi.transaction.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;

import lombok.Getter;

@Document(collection = "bizTransaction")
@Getter
public class BizNaviTransactionDto {

	@Id
	private String id;
	private final String stName;
	private final String glName;
	private final int dist;
	private final boolean finish;

	final List<BizNaviLocationInfoDto> locationInfos;

	public BizNaviTransactionDto() {
		this.id = null;
		this.stName = null;
		this.glName = null;
		this.dist = 0;
		this.finish = false;
		this.locationInfos = Lists.newArrayList();
	}

	/**
	 * @param transactionId transaction ID
	 * @param startPlaceName 출발지 명
	 * @param goalPlaceName 도착지 명
	 * @param totalDistance 총 거리(m)
	 * @param transactionFinished transaction 종료 여부
	 */
	public BizNaviTransactionDto(
		final String transactionId,
		final String startPlaceName,
		final String goalPlaceName,
		final int totalDistance,
		boolean transactionFinished
	) {
		this.id = transactionId;
		this.stName = startPlaceName;
		this.glName = goalPlaceName;
		this.dist = totalDistance;
		this.finish = transactionFinished;
		this.locationInfos = Lists.newArrayList();
	}
}

