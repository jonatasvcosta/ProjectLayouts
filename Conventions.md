# CONVENTIONS - TestProject Android

## Strings name attribute

- All strings should be on `strings.xml`
- The pattern for each string is `<screen_or_component_name> _ <string_name>`
- Use comments to separate sections on the strings file

``` xml
    <!-- HOME -->
    <string name="home_user_balance">Olá %s, seu saldo é de</string>
    <string name="home_user_points">%d pontos</string>
    <string name="home_user_expiring_points">%d pontos expiram esse mês</string>
    <string name="home_check_balance">Ver extrato</string>
    <string name="home_offer_valid_date">Oferta válida de %1$s a %2$s</string>

    <!-- ERROR -->
    <string name="error_message">Não foi possível estabelecer conexão. Tente novamente.</string>
    <string name="error_title">Sem conexão</string>
    <string name="error_description">Não foi possível estabelecer conexão. Tente novamente.</string>
    <string name="error_button_title">Tentar novamente</string>
    <string name="error_field_validation">Por favor verifique os campos indicados</string>
```

## Layout files name

- All files should have a prefix (either `activity_` or `component_` or `fragment_` etc) which explains what it is

## Layout pro tips

The attributes should go on the following order:

- `android:id`
- `style`
- `orientation` (for LinearLayout)
- `android:layout_` 
- other attributes

Observations:
- **Avoid a deep hierarchy of views**. Sometimes you might be tempted to just add yet another LinearLayout, to be able to accomplish an arrangement of views.
- `tools:text` can have hardcoded values, i.e. these values doesn't need to be mapped to strings.xml
- `android:` namespace should go before custom namespaces (`tools`, `app` etc)

## id

- The pattern is `<component_name> _ <sub_component_name>`

``` 
component_balance
fragment_register
activity_about
```

## ButterKnife

- Use it whenever possible to bind your activity/fragment/holder/component views.
- Avoid using it to bind click events.
- All bound views should have the default access level modifier, unless the `public` or `protected` modifiers are required (`ButterKnife` does not bind `private` views). Read about different access level modifiers [here](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html).
- View binds should follow the pattern shown below to improve readability:

```
@Bind(R.id.your_view_id)
View mYourView

@Bind(R.id.another_view_id)
View mAnotherView
```

## interface
- We follow this [convention](http://stackoverflow.com/questions/2814805/java-interfaces-implementation-naming-convention)
- When we want to establish a communication between classes (iOS protocols/delegate), add a suffix `Listener` to your interface
``` java
    public interface LoadingListener {
        void loadingWillAppear();
        void loadingDidDisappear();
    }
```

## enums
- [We should strictly avoid using enums on Android](http://developer.android.com/training/articles/memory.html#Overhead)

## if-else statements
- We're using this format from this [source](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html)
``` java
    if (isMoving) {
        currentSpeed--;
    } else {
        System.err.println("The bicycle has already stopped!");
    } 
```
Pay attention to the use of curly braces, the position of if-else keywords and the spaces between characters

## Front-end activity/fragment creation
- Every screen/component created by the front-end team should be accessible from the guide
- Every screen should have an activity and its fragment. The activity file should be created on the styleguide package and the fragment file should be created on the project package
- The activity and its layout should have the following name format: `"Sample" activity_name "Activity"`, `"activity_sample_" activity_name`
- The fragment should be populated with some mock data which comes from the fragment class. On the integration phase, this mock data will be moved to the `SampleActivity` or a provider or somewhere else, so the styleguide doesn't crash after the integration phase. As we discussed, on the integration phase we will create some `callback interfaces` or use `new instance` idea to move the mock data out of the fragment class.
  - ex: `SampleProductDetailsActivity`, `activity_sample_product_details`

## Front-end component creation
- When creating a new component XML, try to use `<merge>` as the root tag whenever possible.

So, we should have something like this:
``` xml
<?xml version="1.0" encoding="utf-8"?>
<!-- <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/color_white"> -->
<merge
    xmlns:android="http://schemas.android.com/apk/res/android">
    ... <!-- component views -->
</merge>
<!-- </LinearLayout> -->
```
- The real layout (LinearLayout in our example) should be commented to help when re-visiting this xml)
- See http://developer.android.com/guide/topics/resources/layout-resource.html#merge-element
- Pay attention to these points when using it:
  - The basic idea is that every view inside the merge tag will be loaded inside the view that inflates it, so the merge tag only "holds" the components.
  - That raises a couple problems: you can`t set a background or margins/padding on the 'merge' view. If you want to customise the root view, it has to be done trough code.
  - If your view is a relative/linear layout, you won't be able to preview it normally. There is way to preview your merge tag inside another layout, which requires another layout just to preview your component. See: http://stackoverflow.com/a/23560447. Since this approach is not very practical we're not using it
