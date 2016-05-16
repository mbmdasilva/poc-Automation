package com.tr.risk.wco.test;

import java.util.UUID;

public class TestDomainAPIService implements TestDomain {

    @Override
    public String getID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getName() {
        return "mm";
    }
    /*@Override
    public Set<FeatureType> getFeatureTypesForCurrentUser() {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public User getUser(String s) {
        User user = new User();
        user.setId(s);
        user.setFirstName("mateu");
        return user;
    }

    @Override
    public String createUser(CreateUserRequest createUserRequest) {
        return UUID.randomUUID().toString();
    }

    @Override
    public Outcome updateGroupMembership(UpdateGroupMembershipRequest updateGroupMembershipRequest) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public User updateUser(UpdateUserDetails updateUserDetails) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public IdentifierCollection getGroupMembership(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public IdentifierCollection getActiveGroupMembership(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public Set<User> getDescendants(Set<String> set) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public Set<User> getAncestors(Set<String> set) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public IdentifierCheck isExistingUser(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public User updateUserRoles(String s, Set<String> set, Set<String> set1) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummaryCollection getUsersVisibleToAuthenticatedUser() {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public Outcome isUserVisibleToAuthenticatedUser(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public Outcome isUserMemberOfGroup(String s, String s1) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public WorldCheckDataSetType getMaximalWorldCheckSubscriptionType() {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummaryCollection getGroupAdministrators(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummaryCollection getActiveClientAdministrators() {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummaryCollection getTrAdministrators() {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummaryCollection getUsersForRole(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public User deleteUser(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public User createTRAdminUser(User user, String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public UserSummary getUserSummary(String s) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public Set<User> getActiveMembersOfGroups(Set<String> set) {
        throw new NotImplementedException("Not currently supported");
    }

    @Override
    public void generateCollaborationEventForUserCreation(User user) {

    }

    @Override
    public void deleteClientUsers(String s) {

    }*/
}
