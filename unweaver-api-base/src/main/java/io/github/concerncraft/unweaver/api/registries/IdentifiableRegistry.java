package io.github.concerncraft.unweaver.api.registries;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IdentifiableRegistry<V> implements Registry<Identifier, V> {

    private final BiMap<Identifier, V> underlying;

    public IdentifiableRegistry() {
        this.underlying = HashBiMap.create();
    }

    public IdentifiableRegistry(@NotNull BiMap<Identifier, V> underlying) {
        Preconditions.checkNotNull(underlying);
        this.underlying = underlying;
    }

    @Override
    public V register(@NotNull Identifier key, V value) {
        return underlying.put(key, value);
    }

    @Override
    public V get(Identifier key) {
        return underlying.get(key);
    }

    /**
     * @deprecated please use {@link #getId} for clarity.
     */
    @Override
    @Deprecated
    public Identifier getKey(V value) {
        return underlying.inverse().get(value);
    }

    public Optional<Identifier> getId(V value) {
        return Optional.ofNullable(underlying.inverse().get(value));
    }

}
