          (function(){
		  
		  window.liste = {};

            /*--- Mod? note ---*/

            liste.note = Backbone.Model.extend({
                defaults : {
                    lieu : "lieu de la note",
                    desc : "description de la note",
					num  :  "0"
                },
                initialize : function () {
                    console.log ("Cr?ion d'une nouvelle note");
                    this.set("publicationDate",new Date());
					
                }
            });

            /*--- Collection de notes ---*/

            liste.noteCollection = Backbone.Collection.extend({
                model : liste.note,
                initialize : function () {
                    console.log ("Cr?ion d'une collection de notes")
                }
            });

            /*--- Vues ---*/
			/*--- Vues notes ---*/
            liste.noteView = Backbone.View.extend({

                el : $("#notes-collection-container"),

                initialize : function () {
                    this.template = _.template($("#notes-collection-template").html());

                    /*--- binding ---*/
                    _.bindAll(this, 'render');

                    this.collection.bind('change', this.render);
                    this.collection.bind('add', this.render);
					
                    this.collection.bind('remove', this.render);
                    /*---------------*/
                },

                render : function () {
                    var renderedContent = this.template({ 
                        notes : this.collection.toJSON() 
                    });
                    $(this.el).html(renderedContent);
                    return this;
                }
            });
			/*--- Vues formulaire ---*/
			liste.formView = Backbone.View.extend({
			 el : $("#info"),

                initialize : function () {
					
                    this.template = _.template($("#notes-collection-template").html());

                    /*--- binding ---*/
                    _.bindAll(this, 'render');

                    this.collection.bind('change', this.render);
                    this.collection.bind('add', this.render);
					
                    this.collection.bind('remove', this.render);
                    /*---------------*/
                },

                render : function () {
                    var renderedContent = this.template({ 
                        notes : this.collection.toJSON() 
                    });
                    $(this.el).html(renderedContent);
                    return this;
                }
			});
			}).call(this);
			