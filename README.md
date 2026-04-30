# MonifactoryLDLibPatch

A patch to SelectorWidget in LDLib mod for Minecraft modpack [Monifactory](https://github.com/ThePansmith/Monifactory).

The original implementation of MoniLabs (a core component of Monifactory) is flawed: selecting an option in the SelectorWidget causes the game to crash when the client player's UI language does not match the server language. Because LDLib's SelectorWidget does not support automatic UI internationalization (i18n), MoniLabs uses this flawed implementation to display localized text on the SelectorWidget.

In this flawed implementation, MoniLabs uses the localized string as the SelectorWidget item, and attempting to look up the corresponding object backward from the currently selected string when the option changes. When the languages do not match, the option string sent by the client will return null in the server's Map lookup, resulting in a NullPointerException and server crash.

This patch modifies the implementation in MoniLabs and brings true automatic internationalization support to SelectorWidget to fix crashes. In this patch, SelectorWidget will use strings as translation keys instead of directly for display.

## Affected classes

- [LDLib](https://github.com/Low-Drag-MC/LDLib-MultiLoader)
    - [SelectorWidget](https://github.com/Low-Drag-MC/LDLib-MultiLoader/blob/1.20.1/common/src/main/java/com/lowdragmc/lowdraglib/gui/widget/SelectorWidget.java)
- [MoniLabs](https://github.com/NegaNote/MoniLabs)
    - [AdvancedChromaSensorHatchPartMachine](https://github.com/NegaNote/MoniLabs/blob/main/src/main/java/net/neganote/monilabs/common/machine/part/AdvancedChromaSensorHatchPartMachine.java)
    - [AdvancedMicroverseStabilitySensorHatchPartMachine](https://github.com/NegaNote/MoniLabs/blob/main/src/main/java/net/neganote/monilabs/common/machine/part/AdvancedMicroverseStabilitySensorHatchPartMachine.java)

---

MoniLabs（Monifactory 的核心组件）的原始实现存在缺陷：当客户端玩家的 UI 语言与服务器语言不匹配时，选择 SelectorWidget 中的选项会导致游戏崩溃。由于 LDLib 的 SelectorWidget 不支持自动 UI 国际化，MoniLabs 使用了这种有缺陷的实现方式来在 SelectorWidget 上显示本地化文本。

在这种有缺陷的实现方式中，MoniLabs 将本地化后的字符串用作 SelectorWidget 的元素，并且仅在选项更改时尝试从当前选中的字符串反向查找对应的对象。当语言不匹配时，客户端发送的选项字符串到了服务器的 Map 查询中会返回 null，从而导致 NullPointerException 异常和服务器崩溃。

此补丁将修改 MoniLabs 中的实现方式，并为 SelectorWidget 带来真正的自动国际化支持以修复崩溃问题。在此补丁中，SelectorWidget 将使用字符串作为翻译键，而不是直接用于显示。