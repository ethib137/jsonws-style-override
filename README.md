# jsonws-style-override

![gif](/images/JSONWS.gif)

So, I've been hitting Liferay 7.2's /api/jsonws page to get info on JSON
web service methods that Liferay provides and, well, I just have to say
I don't like it.

I mean, the page is hard coded to a width of 960 pixels. Seriously? I mean,
it's not a problem if you're doing development on your iPad Air or something,
but I just don't.

To me, this is a development resource. I don't need it to be pretty with
huge margins on the top and bottom and big reading gaps on the sides.

So, I thought, if I don't like it, I can just change it.

And I did.

This project has a simple Custom JSP Bag to override the default /html/portal/api/jsonws/css.jspf
file to fix some of the styling that I think is just off.

Feel free to clone and modify if you want, but I think the current settings are pretty reasonable.

Enjoy!

P.S. Although this is for 7.2, I think you can downgrade it reasonably well to 7.0 or 7.1. Just fix your versions
in the build.gradle file and give it a whirl. No promises of course, but it can't hurt to try.

## Deploy

` $ blade deploy `

This will deploy it to `/bundles/osgi/modules`.

If you want to deploy it to a bundle that lives somewhere else you can add a `gradle-local.properties` file with the following property pointing to your bundle location: `liferay.workspace.home.dir=`.
