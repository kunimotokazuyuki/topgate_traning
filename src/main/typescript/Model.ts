///<reference path='libs/DefinitelyTyped/angularjs/angular.d.ts' />

/**
 * モデルのModuleです*/
 module Model {
	export class Sample {
		test:string;

		/**
		 * @constructor
		 * @param data JSONObjectまたはJSON文字列
		 */
			constructor(data) {
			if (angular.isString(data)) {
				data = angular.fromJson(data);
			}
			this.test = data.test;
		}
	}
			export class Todo{
                 /*publicを入れると値を入れることが出来る
                contentを定義dしてくれる。
                * */
				constructor(public content:string = "Unkown" ){}
            }

}




