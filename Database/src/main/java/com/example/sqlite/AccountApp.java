package com.example.sqlite;

import net.inference.Config;
import net.inference.database.DatabaseApi;
import net.inference.database.dto.Article;
import net.inference.sqlite.SqliteApi;
import net.inference.sqlite.dto.ArticleImpl;

/**
 * Date: 12/19/2014
 * Time: 3:29 PM
 *
 * @author xanderblinov
 *
 */


/**
 * this just a sample. All tests should be written in test folder
 */
public class AccountApp
{

	public static void main(String[] args) throws Exception
	{

		DatabaseApi databaseApi = new SqliteApi(Config.Database.LIVE);
		databaseApi.onStart();

		// create an instance of ArticleImpl
		Article article = new ArticleImpl();
		article.setName("Article 1");
		databaseApi.article().addArticle(article);


		Article article2 = databaseApi.article().getAllArticles().get(0);

		System.out.println("Article: " + article2.getName());

		databaseApi.onStop();
	}
}
