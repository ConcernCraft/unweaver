package io.github.concerncraft.unweaver.api.registries;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface Registry<K, V> {

    @Contract("!null, _ -> param2")
    V register(@NotNull K key, V value);

    @Nullable V get(K key);

    default V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return value == null ? defaultValue : value;
    }

    default Optional<V> maybeGet(K key) {
        return Optional.ofNullable(get(key));
    }

    K getKey(V value);

    default Optional<K> maybeGetKey(V key) {
        return Optional.ofNullable(getKey(key));
    }

}
