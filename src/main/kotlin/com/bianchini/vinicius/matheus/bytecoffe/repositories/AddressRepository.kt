package com.bianchini.vinicius.matheus.bytecoffe.repositories

import com.bianchini.vinicius.matheus.bytecoffe.domain.entity.address.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AddressRepository : JpaRepository<Address, String?> {

    @Query("from address a where a.profile_id = :profileId")
    fun findByProfileId(profileId: String): Address?
}
