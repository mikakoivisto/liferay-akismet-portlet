create table Akismet_AkismetComment (
	akismetCommentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	mbMessageId LONG,
	author VARCHAR(75) null,
	authorEmail VARCHAR(75) null,
	authorUrl VARCHAR(75) null,
	content VARCHAR(75) null,
	permalink VARCHAR(75) null,
	referrer VARCHAR(75) null,
	type_ VARCHAR(75) null,
	userAgent VARCHAR(75) null,
	userIp VARCHAR(75) null,
	spam BOOLEAN
);

create table Akismet_AkismetGroupStats (
	akismetGroupStatsId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	spamCount LONG,
	hamCount LONG
);

create table Akismet_AkismetMBMessage (
	akismetMBMessageId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	mbMessageId LONG,
	spam BOOLEAN,
	author VARCHAR(75) null,
	authorEmail VARCHAR(75) null,
	authorUrl VARCHAR(75) null,
	content STRING null,
	permalink STRING null,
	referrer STRING null,
	type_ VARCHAR(75) null,
	userAgent VARCHAR(75) null,
	userId LONG,
	userIp VARCHAR(75) null
);