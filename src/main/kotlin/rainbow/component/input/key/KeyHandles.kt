package rainbow.component.input.key

/**
 * 用于存贮所有的[KeyHandle]
 * @author Rainbow Yang
 */
abstract class KeyHandles<Owner : KeyHandlesOwner>(val owner: Owner) : KeyHandlesOwner {

    val handles = mutableListOf<KeyHandle>()

    fun runHandle(key: Key, time: Number) = handles.forEach { it.runHandle(key, time) }

    protected operator fun Int.invoke(handle: (Int) -> Unit) {
        val key = Key(this)
        val keyHandle = KeyHandle(trigger = key, handle = handle)
        handles.add(keyHandle)
    }

    override fun registerTo(observable: KeyInputSender) {
        observable.addHandles(this)
    }
}

